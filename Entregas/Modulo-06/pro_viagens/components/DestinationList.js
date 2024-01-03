import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';
import DestinationCard from './DestinationCard';
import DestinationCardPromos from './DestinationCardPromos';

const DestinationList = ({ destinations }) => (
  <section className="row row-cols-2 row-cols-md-3 g-4">
    {destinations.map((destination) => (
      destination.type === "Promocão" ? (
        <DestinationCardPromos key={destination.id} destination={destination} />
      ) : (
        <DestinationCard key={destination.id} destination={destination} />
      )
    ))}
  </section>
);


export default DestinationList;