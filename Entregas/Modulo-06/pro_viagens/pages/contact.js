import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import style from '@/styles/Contact.module.css';
import Head from 'next/head';

export default function () {
  return (
    <section className={`${style.section}`}>

      <Head>
        <title>Contato</title>
        <meta name="description" content="pag de contato" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/imagens/pro_agency_k5D_icon.ico" />
      </Head>

      <form className={`container form ${style.form}`}>
        <div className={`input-group ${style.inputGroup}`}>
          <div className={`input-group-text ${style.inputGroupText}`}>
            <img height="30px" src="/imagens/icons8-telefone-96.png" />
          </div>
          <h1 className={`form-control text-primary-emphasis ${style.contact}`}>
            (55) 9999-9999
          </h1>
        </div>
        <div className={`input-group ${style.inputGroup}`}>
          <div className={`input-group-text ${style.inputGroupText}`}>
            <img height="30px" src="/imagens/icons8-email-35.png" />
          </div>
          <h1 className={`form-control text-primary-emphasis ${style.contact}`}>
            kelvendev@gmail.com
          </h1>
        </div>
        <div className="form-outline mb-4">
          <input type="text" id="form4Example1" className="form-control" />
          <label className="form-label text-white" htmlFor="form4Example1">
            Nome
          </label>
        </div>
        <div className="form-outline mb-4">
          <input type="email" id="form4Example2" className="form-control" />
          <label className="form-label text-white" htmlFor="form4Example2">
            Email
          </label>
        </div>
        <div className="form-outline mb-4">
          <textarea
            className="form-control"
            id="form4Example3"
            rows={4}
            defaultValue={""}
          />
          <label className="form-label text-white" htmlFor="form4Example3">
            Mensagem
          </label>
        </div>
        <button type="submit" className="btn btn-primary btn-block mb-4">
          Send
        </button>
      </form>
    </section>
  )
}
