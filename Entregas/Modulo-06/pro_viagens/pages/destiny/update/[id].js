import { useState, useEffect } from "react";

import axios from "axios";

import { useRouter } from 'next/router';
import Head from "next/head";

const UpdateDestiny = () => {

  const [destiny, setDestiny] = useState({
    name: "",
    imgUrl: "",
    price: "",
    description: "",
    type: ""
  });

  const router = useRouter();

  const { id } = router.query;

  useEffect(() => {

    // Faça uma chamada GET para a API para obter detalhes do destino a ser atualizado

    axios

      .get("http://localhost:8080/destiny/" + id)

      .then((response) => {

        setDestiny(response.data);

      })

      .catch((error) => {

        console.error("Erro ao buscar detalhes do destino:", error);

      });

  }, [id]);

  const handleInputChange = (e) => {
    setDestiny({ ...destiny, [e.target.name]: e.target.value });

  };

  const handleUpdateDestiny = (e) => {
    e.preventDefault();
    axios

      .put("http://localhost:8080/edit/" + id, destiny)
      .then((response) => {
        router.push("/");

      })

      .catch((error) => {
        console.error("Erro ao atualizar destino:", error);

      });
  };


  return (
    <div className="container mt-3" style={{ paddingTop: "60px", paddingBottom: "30px" }}>

      <Head>
        <title>Atualizar Destino</title>
        <meta name="description" content="atualizar destino"/>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/imagens/pro_agency_k5D_icon.ico" />
      </Head>

      <h2 className="text-center mb-4">Atualizar Destino</h2>
      <form style={{ marginBottom: "28px" }} onSubmit={handleUpdateDestiny}>

        <div className="mb-3">
          <label htmlFor="type" className="form-label">Categoria:</label>
          <select name="type" className="form-select" value={destiny.type} onChange={handleInputChange} required>
            <option value="" disabled selected hidden>Selecione uma categoria</option>
            <option value="Nacional">Nacional</option>
            <option value="Internacional">Internacional</option>
            <option value="Promocão">Promocão</option>
          </select>
        </div>

        <div className="mb-3">
          <label htmlFor="name" className="form-label">Título:</label>
          <input type="text" name="name" className="form-control"
            value={destiny.name}
            onChange={handleInputChange}
            required />
        </div>

        <div className="mb-3">
          <label htmlFor="imgUrl" className="form-label">URL da Imagem:</label>
          <input type="text" name="imgUrl" className="form-control"
            value={destiny.imgUrl}
            onChange={handleInputChange}
            required />
        </div>

        <div className="mb-3">
          <label htmlFor="description" className="form-label">Descrição:</label>
          <input type="text" name="description" className="form-control"
            value={destiny.description}
            onChange={handleInputChange}
            required />
        </div>

        <div className="mb-3">
          <label htmlFor="price" className="form-label">Preço:</label>
          <input type="number" name="price" className="form-control"
            value={destiny.price}
            onChange={handleInputChange}
            required />
        </div>

        <div className="d-flex justify-content-center">
          <button style={{ marginTop: "10px" }} type="submit" className="btn btn-primary">Salvar</button>
        </div>
      </form>
    </div>
  );
};

export default UpdateDestiny;