import 'bootstrap/dist/css/bootstrap.css';
import { useEffect, useState } from "react";
import { Carousel } from 'react-bootstrap';
import styles from '@/styles/Home.module.css';
import DestinationList from '@/components/DestinationList';
import axios from "axios";
import Head from 'next/head';
import Link from 'next/link';


export default function Home() {

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

  const destinationsNacional = destinations.filter(
    (destination) => destination.type === "Nacional"
  );

  const destinationsInternacional = destinations.filter(
    (destination) => destination.type === "Internacional"
  );

  return (
  <div style={{ paddingBottom: "70px" }}>
      <Head>
        <title>Pro Agency</title>
        <meta name="description" content="home do projeto" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/imagens/pro_agency_k5D_icon.ico" />
      </Head>

      {/* carousel */}
      <Carousel interval={3000} controls={false} indicators={false}>
        <Carousel.Item className={`${styles.carouselItem}`}>
          <img
            className={`d-block w-100 ${styles.carouselImage}`}
            src="imagens/rio-de-janeiro.jpg"
            alt="rio de janeiro"
          />
          <div className={`carousel-text fw-bold ${styles.carouselText}`}>
            <div>Rio de Janeiro</div>
            <div className={`pagamento ${styles.pagamento}`}>
              <sup>10x</sup> R$70
            </div>
          </div>
        </Carousel.Item>
        <Carousel.Item className={`${styles.carouselItem}`}>
          <img
            className={`d-block w-100 ${styles.carouselImage}`}
            src="imagens/disney.jpg"
            alt="disney"
          />
          <div className={`carousel-text fw-bold ${styles.carouselText}`}>
            <div>Disney</div>
            <div className={`pagamento ${styles.pagamento}`}>
              <sup>10x</sup> R$130
            </div>
          </div>
        </Carousel.Item>
        <Carousel.Item className={`${styles.carouselItem}`}>
          <img
            className={`d-block w-100 ${styles.carouselImage}`}
            src="imagens/paris.jpg"
            alt="paris"
          />
          <div className={`carousel-text fw-bold ${styles.carouselText}`}>
            <div>Paris</div>
            <div className={`pagamento ${styles.pagamento}`}>
              <sup>10x</sup> R$200
            </div>
          </div>
        </Carousel.Item>
      </Carousel>

      <div className={`bg-dark ${styles.btnAddCard}`}>
        
          <Link className="btn fw-bold text-black btn-warning fs-6" href={"/destiny/add"}>Adicionar Destino</Link>
      </div>

      {/* Listagem de destinos nacionais */}
      <h2 className={`fw-bold ${styles.nacionalTitle}`}>
        Nacional <img height="35px" src="imagens/brazi-flag.png"/> - viagens e tour
      </h2>

      <DestinationList destinations={destinationsNacional}/>

      {/* Listagem de destinos Internacionais*/}
      <h2 className={`fw-bold ${styles.internacionalTitle}`}>
        Internacional <img height="45px" src="imagens/global-flag.png" /> - viagens e tour
      </h2>
      <DestinationList destinations={destinationsInternacional}/>
    </div>
  );
}