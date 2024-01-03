import { useState, useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.css';
import axios from "axios";
import { useRouter } from "next/router";
import Head from "next/head";

const DeleteDestiny = () => {

  const router = useRouter();
  const { id } = router.query;

  const [destination, setDestination] = useState([]);
  useEffect(() => {

    axios
      .get("http://localhost:8080/destiny/" + id)
      .then((response) => {
        setDestination(response.data);

      })
      .catch((error) => {
        console.error("Erro ao buscar a lista de destino:", error);
      });
  }, []);


  const handleDeleteDestiny = () => {

    axios
      .delete("http://localhost:8080/destiny/" + id)
      .then(() => {
        router.push("/");
      })
      .catch((error) => {
        alert("Erro ao excluir destino:" + error);
      });

  };


  return (
    <div style={{ paddingTop: "50px", height: "100vh"}}>

      <Head>
        <title>Excluir Destino</title>
        <meta name="description" content="excluir destino" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/imagens/pro_agency_k5D_icon.ico" />
      </Head>

      <h1 className={`h1Mod`}> Excluir destino</h1>

      <div style={{ display: "flex", alignItems: "center", justifyContent: "center" }} className="row row-cols-2 row-cols-md-3 g-4 col">
        <div className="card">
          <img height="300px" className="card-img-top" src={destination.imgUrl} alt={destination.name} />
          <div className="card-body">
            <h4 className="card-title fw-bold">{destination.name}</h4>
            <button style={{ alignItems: "right" }} className="btn btn-danger" onClick={handleDeleteDestiny}>Excluir destino</button>
          </div>
        </div>
      </div>

    </div>
  );

};

export default DeleteDestiny;