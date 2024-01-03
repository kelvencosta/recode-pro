import { useState } from "react";
import axios from "axios";
import { useRouter } from "next/router";
import Head from "next/head";

const AddDestiny = () => {

  const [newDestiny, setNewDestiny] = useState({
    name: "",
    imgUrl: "",
    price: "",
    description: "",
    type: ""
  });

  const router = useRouter();

  const handleInputChange = (e) => {

    setNewDestiny({ ...newDestiny, [e.target.name]: e.target.value });

  };

  const handleAddDestiny = (e) => {
    e.preventDefault();

    axios

      .post("http://localhost:8080/register/destiny", newDestiny)
      .then((response) => {
        router.push("/");

      })

      .catch((error) => {
        alert("Erro ao inserir destino:" + error);

      });

  };

  return (

    <div className="container" style={{ paddingTop: "60px", height: "100vh" }}>

      <Head>
        <title>Adicionar Destino</title>
        <meta name="description" content="adicionar destino" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/imagens/pro_agency_k5D_icon.ico" />
      </Head>

      <h2 className="text-center mb-4">Cadastro de Destino</h2>

      <form onSubmit={handleAddDestiny}>
        <div className="row mb-3">
          <div className="col-md-6">
            <label htmlFor="name" className="form-label">Título:</label>
            <input
              type="text"
              name="name"
              value={newDestiny.name}
              className="form-control"
              onChange={handleInputChange}
              required
            />
          </div>
          <div className="col-md-6">
            <label htmlFor="imgUrl" className="form-label">URL da Imagem:</label>
            <input
              type="text"
              name="imgUrl"
              value={newDestiny.imgUrl}
              className="form-control"
              onChange={handleInputChange}
              required
            />
          </div>
        </div>

        <div className="mb-3">
          <label htmlFor="description" className="form-label">Descrição:</label>

          <input
            type="text"
            name="description"
            value={newDestiny.description}
            className="form-control"
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="mb-3">
          <label htmlFor="price" className="form-label">Preço:</label>
          <input
            type="number"
            name="price"
            value={newDestiny.price}
            className="form-control"
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="mb-3">

          <label htmlFor="type" className="form-label">Categoria:</label>

          <select name="type" className="form-select" value={newDestiny.type} onChange={handleInputChange} required>
            <option value="" disabled selected hidden>Selecione uma categoria</option>
            <option value="Nacional">Nacional</option>
            <option value="Internacional">Internacional</option>
            <option value="Promocão">Promocão</option>
          </select>
        </div>

        <div className="d-flex justify-content-center">
          <button type="submit" className="btn btn-primary btn">Salvar</button>
        </div>
      </form>
    </div>
  );

};


export default AddDestiny;