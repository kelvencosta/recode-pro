import { useState } from "react";
import axios from "axios";
import { useRouter } from "next/router";
import Head from "next/head";
import React from 'react'
import 'bootstrap/dist/css/bootstrap.css'
import style from "@/styles/Register-edit.module.css"
import Script from "next/script";
import InputMask from 'react-input-mask';

export default function register() {

  const [newClient, setNewClient] = useState({
    name: "",
    cpf: "",
    rg: "",
    tel: "",
    email: ""
  });

  const router = useRouter();

  const handleInputChange = (e) => {

    setNewClient({ ...newClient, [e.target.name]: e.target.value });

  };

  const handleRegisterClient = (e) => {
    e.preventDefault();

    axios
      .post("http://localhost:8080/client/register", newClient)
      .then((response) => {
        localStorage.setItem('id', response.data.id);
        router.push("/");
      })

      .catch((error) => {
        alert("Erro ao registrar cliente:" + error);
      });
  };

  return (
    <div className={`${style.registrationForm} ${style.div}`} style={{ height: "100vh", paddingTop: "65px" }}>

      <Head>
        <title>Cadastro</title>
        <meta name="description" content="cadastro de cliente" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/imagens/pro_agency_k5D_icon.ico" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
          rel="stylesheet" />
        <Script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></Script>
        <Script type="text/javascript"
          src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></Script>
      </Head>

      <form onSubmit={handleRegisterClient}>
        <div className={`${style.formIcon}`}>
          <span>
            <i className="icon icon-user" />
          </span>
        </div>
        <div className="form-group">
          <input
            className={`form-control item ${style.itemMod}`}
            type="text"
            placeholder="Name"
            name='name'
            value={newClient.name}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group">
          <InputMask
            className={`form-control ${style.itemMod}`}
            type="text"
            placeholder="CPF"
            name='cpf'
            value={newClient.cpf}
            onChange={handleInputChange}
            id="cpf"
            mask="999.999.999-99"
            required
          />
        </div>
        <div className="form-group">
          <input
            className={`form-control ${style.itemMod}`}
            type="text"
            placeholder="RG"
            name='rg'
            value={newClient.rg}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group">
          <InputMask
            className={`form-control ${style.itemMod}`}
            type="tel"
            placeholder="Telefone"
            name='tel'
            value={newClient.tel}
            onChange={handleInputChange}
            id="tel"
            mask="(99)9999-9999"
            required
          />
        </div>
        <div className="form-group">
          <input
            className={`form-control ${style.itemMod}`}
            type="email"
            placeholder="Email"
            name='email'
            value={newClient.email}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="form-group div-buttons">
          <input
            type="submit"
            value="Cadastrar-se"
            className={`btn btn-block ${style.createAccount}`}
          />
        </div>
      </form>
    </div>
  )
}