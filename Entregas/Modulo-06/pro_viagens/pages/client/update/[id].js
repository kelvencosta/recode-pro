import axios from 'axios';
import { useRouter } from 'next/router';
import React, { useEffect, useState } from 'react'
import Head from "next/head";
import InputMask from 'react-input-mask';
import style from "@/styles/Register-edit.module.css"

export default function () {

  const [client, setClient] = useState({
    name: "",
    cpf: "",
    rg: "",
    tel: "",
    email: ""
  });

  const router = useRouter();

  const { id } = router.query;

  useEffect(() => {

    // Faça uma chamada GET para a API para obter detalhes do cliente a ser atualizado

    axios
      .get("http://localhost:8080/client/perfil/" + id)
      .then((response) => {
        setClient(response.data);

      })

      .catch((error) => {
        console.error("Erro ao buscar detalhes do cliente:", error);

      });

  }, [id]);


  const handleInputChange = (e) => {
    setClient({ ...client, [e.target.name]: e.target.value });

  };

  const handleUpdateClient = (e) => {
    e.preventDefault();

    axios
      .put("http://localhost:8080/client/edit/" + id, client)
      .then((response) => {
        router.push("/client/perfil");

      })

      .catch((error) => {
        console.error("Erro ao atualizar cliente:", error);

      });
  };

  return (
    <div className={`${style.registrationForm} ${style.div}`} style={{ height: "100vh", paddingTop: "70px" }}>
      <Head>
        <title>Atualizar Dados</title>
        <meta name="description" content="atualixar dados" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/imagens/pro_agency_k5D_icon.ico" />
      </Head>

      <form onSubmit={handleUpdateClient}>
        <div>
          <h2 className="h2">
            <span className="text-info">
              {client.name},&nbsp;
            </span>
           Atualize os seus dados
          </h2>
        </div>
        <div className="form-group">
          <input
            className={`form-control item ${style.item}`}
            type="text"
            placeholder="Name"
            name='name'
            value={client.name}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group">
          <InputMask
            className={`form-control item ${style.item}`}
            type="text"
            placeholder="CPF"
            name='cpf'
            value={client.cpf}
            onChange={handleInputChange}
            id="cpf"
            mask="999.999.999-99"
            required
          />
        </div>
        <div className="form-group">
          <input
            className={`form-control item ${style.item}`}
            type="text"
            placeholder="RG"
            name='rg'
            value={client.rg}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group">
          <InputMask
            className={`form-control item ${style.item}`}
            type="tel"
            placeholder="Telefone"
            name='tel'
            value={client.tel}
            onChange={handleInputChange}
            id="tel"
            mask="(99)9999-9999"
            required
          />
        </div>
        <div className="form-group">
          <input
            className={`form-control item ${style.item}`}
            type="email"
            placeholder="Email"
            name='email'
            value={client.email}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group div-buttons">
          <input
            type="submit"
            value="Atualizar dados"
            className={`btn btn-block ${style.createAccount}`}
          />
        </div>
      </form>
    </div>

  )
}
