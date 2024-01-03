import { useState, useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.css';
import axios from "axios";
import { useRouter } from "next/router";
import Head from "next/head";
import style from "@/styles/Reserve.module.css";

const reserve = () => {

  const formatCurrency = (value) => {
    return new Intl.NumberFormat('pt-BR', {
      style: 'currency',
      currency: 'BRL',
    }).format(value);
  };

  const [newReserve, setNewReserve] = useState({
    date_travel: "",
  });

  const router = useRouter();
  const { id } = router.query;

  const handleInputChange = (e) => {
    setNewReserve({ ...newReserve, [e.target.name]: e.target.value });
  };

  const [destination, setDestination] = useState([]);
  useEffect(() => {

    axios
      .get(`http://localhost:8080/destiny/${id}`)
      .then((response) => {
        setDestination(response.data);
      })
      .catch((error) => {
        console.error("Erro ao buscar destino:", error);
      });
  }, []);

    const handleCreateReserve = async (e) => {
      e.preventDefault();
  
      const clientId = localStorage.getItem('id');
  
      if (clientId != null) {
        try {
          const response = await axios.post(`http://localhost:8080/reserve/save/${clientId}/${id}`, newReserve);
  
          // Se a reserva for criada com sucesso, redirecione para a página inicial
          alert("Viagem reservada");
          router.push("/");
        } catch (error) {
          if (error.response) {
            // O servidor respondeu com um status de erro
            alert("Cadastre-se primeiro");
          } else if (error.request) {
            // A requisição foi feita, mas não houve resposta do servidor
            alert("Erro de comunicação com o servidor. Tente novamente mais tarde.");
          } else {
            // Um erro ocorreu durante a configuração da requisição
            alert("Erro ao processar a requisição. Tente novamente mais tarde.");
          }
          
          // Redirecione para a página de registro do cliente em caso de erro
          router.push("/client/register");
        }
      }
  };

  return (
    <div className={`${style.div}`}>

      <Head>
        <title>Reservar</title>
        <meta name="description" content="reserva" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/imagens/pro_agency_k5D_icon.ico" />
      </Head>

      <section className={`${style.section}`}>
        <div className={`${style.containerInfo}`}>
          <div className="col">
            <form onSubmit={handleCreateReserve}>
              <div className={`${style.cardDestino}`}>
                <img
                  className={`${style.imgPlace}`}
                  src={destination.imgUrl} alt={destination.name}
                  height="530px"
                  width="450px"
                />
                <div className={`${style.infoReserva}`}>
                  <div className={`${style.titleContainer}`}>
                    <h1>{destination.name}</h1>
                    <img height="28px" src="/imagens/rating-50.png" />
                  </div>
                  <div className={`${style.inputs}`}>
                    <div style={{ textAlign: "right" }}>
                      <span className={`${style.valor}`}>
                        {formatCurrency(destination.price)}
                      </span>
                    </div>
                  </div>
                  <div className={`${style.inputs}`}>
                    <label htmlFor="cartao" className={`${style.codigoLabel}`}>
                      Número do Cartão:
                    </label>
                    <input
                      type="text"
                      id="cartao"
                      name="cartao"
                      className={`${style.cartaoInput}`}
                      required
                    />
                    <label htmlFor="codigo" className={`${style.codigoLabel}`}>
                      Código do Cartão:
                    </label>
                    <input
                      type="text"
                      id="codigo"
                      name="codigo"
                      className={`${style.codigoInput}`}
                      required
                    />
                  </div>
                  <div className={`${style.inputs}`}>
                    <label className="label" htmlFor="Datada viagem">
                      Data da viagem:
                    </label>
                    <input
                      type="date"
                      name="date_travel"
                      value={newReserve.date_travel}
                      onChange={handleInputChange}
                      required
                    />
                  </div>
                  <div className={`${style.reservaDiv}`}>
                    <button type="submit" className={`btn btn-primary button ${style.button}`}>
                      Reservar
                    </button>
                    <img width="382px" src="/imagens/forma-pagamento.png" />
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </section>

    </div>
  );

};

export default reserve;