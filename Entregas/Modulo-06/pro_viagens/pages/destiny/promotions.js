import 'bootstrap/dist/css/bootstrap.css';
import React from 'react'
import { useEffect, useState } from "react";
import axios from "axios";
import Head from 'next/head';
import styles from '@/styles/Promocao.module.css';
import DestinationList from '@/components/DestinationList';

export default function contato() {

  const [destinations, setDestinations] = useState([]);
  useEffect(() => {

    axios
      .get("http://localhost:8080")
      .then((response) => {
        setDestinations(response.data);

      })
      .catch((error) => {
        console.error("Erro ao buscar a lista de destinos:", error);
      });
  }, []);

  const destinationsPromocao = destinations.filter(
    (destination) => destination.type === "Promocão"
  );

  return (
    <div className={`${styles.main}`}>

      <Head>
        <title>Promoções</title>
        <meta name="description" content="promocoes" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/imagens/pro_agency_k5D_icon.ico" />
      </Head>

      <section className={`${styles.planoContainer} ${styles.section}`}>
        <div className={`${styles.planoTitle}`}>

          <h1 className="text-white">
            Plano <span className={`${styles.textYellow}`}>1.000</span>
          </h1>
          <h5 className={`h5 ${styles.textYellow} ${styles.h5}`}>Receba 25.500 MILHAS em 12 meses!</h5>
        </div>
        <div className={`${styles.planoTitle}`}>
          <h5 className="text-white">1.000 milhas por mês</h5>
        </div>
        <div className={`${styles.planoItems}`}>
          <div>
            <p className="text-white">Mensal</p>
          </div>
          <div>
            <p className={`${styles.textYellow}`}>R$ 42,00 ../mês</p>
          </div>
          <div>
            <button type="button" className="btn btn-warning">
              Quero assinar
            </button>
          </div>
        </div>
        <div className={`${styles.planoItems}`}>
          <div>
            <p className="text-white">Anual Parcelado</p>
            <p className="text-light fw-light">em até 12x</p>
          </div>
          <div>
            <p className={`${styles.desconto}`}>5% off</p>
            <p className="text-light fw-light">
              De: <span className={`${styles.lineThrough}`}>R$ 42,00 /mês</span>
            </p>
            <p className={`${styles.textYellow}`}>Por: Até 12x de R$ 39,90</p>
          </div>
          <div>
            <button type="button" className="btn btn-warning">
              Quero assinar
            </button>
          </div>
        </div>
        <div className={`${styles.planoItems}`}>
          <div>
            <p className="text-white">Anual À Vista</p>
          </div>
          <div>
            <p className={`${styles.desconto}`}>10% off</p>
            <p className="text-light fw-light">
              De: <span className={`${styles.lineThrough}`}>De: R$ 504,00 /ano</span>
            </p>
            <p className={`${styles.textYellow}`}>Por: R$ 453,60 /ano</p>
          </div>
          <div>
            <button type="button" className="btn btn-warning">
              Quero assinar
            </button>
          </div>
        </div>
      </section>

      <h2 class={`fw-bold ${styles.promocaoTitle}`}>
        Voos com até 50% de desconto
      </h2>

      <DestinationList destinations={destinationsPromocao}/>
    </div>
  )
}
