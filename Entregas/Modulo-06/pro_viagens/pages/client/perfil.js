import axios from 'axios';
import { useRouter } from 'next/router';
import React, { useEffect, useState } from 'react';
import style from "@/styles/Perfil.module.css";
import 'bootstrap/dist/css/bootstrap.css';
import Link from 'next/link';
import Head from 'next/head';

export default function perfil() {

  const router = useRouter();

  const [client, setClient] = useState([]);
  useEffect(() => {

    const clientId = localStorage.getItem('id');

    if (clientId != null) {
      axios
        .get("http://localhost:8080/client/perfil/" + clientId)
        .then((response) => {
          setClient(response.data);
        })
        .catch((error) => {
          alert("Cadastre-se primeiro.", error);
          router.push("/client/register");
        });
    }
  }, []);


  const handleDeleteClient = () => {

    axios
      .delete("http://localhost:8080/client/delete/" + client.id)
      .then(() => {
        localStorage.setItem("id", null)
        router.push("/");
      })
      .catch((error) => {
        alert("Erro ao excluir cliente:" + error);
      });

  };

  return (
    <div>
      <Head>
        <title>Perfil</title>
        <meta name="description" content="perfil" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/imagens/pro_agency_k5D_icon.ico" />
      </Head>

      <section className={`${style.section}`}>
        <aside className={`${style.containerAside}`}>
          <div className="col-lg-7">
            <div className={`card mb-4 ${style.card}`}>
              <div className="card-body">
                <div className="row">
                  <div className="col-sm-6">
                    <p className="mb-4 h5">Nome</p>
                  </div>
                  <div className="col-sm-6">
                    <p className="text-muted mb-4 h6">{client.name}</p>
                  </div>
                </div>
                <hr className="border border-info" />
                <div className="row">
                  <div className="col-sm-6">
                    <p className="mb-4 h5">CPF</p>
                  </div>
                  <div className="col-sm-6">
                    <p className="text-muted mb-4 h6">{client.cpf}</p>
                  </div>
                </div>
                <hr className="border border-info" />
                <div className="row">
                  <div className="col-sm-6">
                    <p className="mb-4 h5">RG</p>
                  </div>
                  <div className="col-sm-6">
                    <p className="text-muted mb-4 h6">{client.rg}</p>
                  </div>
                </div>
                <hr className="border border-info" />
                <div className="row">
                  <div className="col-sm-6">
                    <p className="mb-4 h5">Telefone</p>
                  </div>
                  <div className="col-sm-6">
                    <p className="text-muted mb-4 h6">{client.tel}</p>
                  </div>
                </div>
                <hr className="border border-info" />
                <div className="row">
                  <div className="col-sm-6">
                    <p className="mb-5 h5">Email</p>
                  </div>
                  <div className="col-sm-6">
                    <p className="text-muted mb-5 h6">{client.email}</p>
                  </div>
                </div>
                <div className="row">
                  <div className={`col-sm-3 ${style.btns}`}>
                    <Link className='btn btn-info' href={`/client/update/${client.id}`}>Editar</Link>
                    <button className='btn btn-danger' onClick={handleDeleteClient}>Excluir</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </aside>
      </section>
    </div>
  )
}