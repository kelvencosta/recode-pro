import 'bootstrap/dist/css/bootstrap.css';
import Link from 'next/link';

import React from 'react';

const DestinationCard = ({ destination }) => (
  <div className="col">
    <div className="card">
      <img height="300px" className="card-imgs card-img-top" src={destination.imgUrl} alt={destination.name} />
      <div className="card-body">
        <h4 className="card-title fw-bold">{destination.name}</h4>
        <p className="card-text">{destination.description}</p>
        <Link className='btn btn-info btn-sm' href={`/destiny/update/${destination.id}`}>Editar</Link>
        <Link className='btn btn-danger btn-sm' href={`/destiny/delete/${destination.id}`}>Excluir</Link>
        <Link className='btn btn-success btn-sm' href={`/reserve/${destination.id}`}>Reservar</Link>
        <span className={'cardsPrice'}>
          {destination.price.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' })}
        </span>
      </div>
    </div>
  </div>
);

export default DestinationCard;