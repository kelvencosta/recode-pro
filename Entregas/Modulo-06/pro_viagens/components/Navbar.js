import 'bootstrap/dist/css/bootstrap.css';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import Link from 'next/link';
import React, { useState } from 'react';

function CustomNavbar() {

  const [paginaAtiva, setPaginaAtiva] = useState('');

  const handlePaginaClick = (pagina) => {
    setPaginaAtiva(pagina);
  };

  return (
    <Navbar className='nav' bg="dark" expand="lg">
      <div className="container-fluid">
        <Navbar.Brand className="text-decoration-underline text-white fs-5">Pro Agency</Navbar.Brand>
        <Navbar.Toggle className="bg-white" aria-controls="navbarSupportedContent" />
        <Navbar.Collapse id="navbarSupportedContent">
          <Nav className="me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <Link className={`nav-link fs-6 ${paginaAtiva === 'Home' ? 'text-warning' : 'text-white'}`} href={"/"} onClick={() => handlePaginaClick('Home')}>Home</Link>
            </li>
            <li className="nav-item">
              <Link className={` text-warning nav-link fs-6 ${paginaAtiva === 'Promocoes' ? 'text-warning' : 'text-white'}`} href={"/destiny/promotions"} onClick={() => handlePaginaClick('Promocoes')}>Promoções</Link>
            </li>
            <li className="nav-item">
              <Link className={`nav-link fs-6 ${paginaAtiva === 'Cadastro' ? 'text-warning' : 'text-white'}`} href={"/client/register"} onClick={() => handlePaginaClick('Cadastro')}>Cadastro</Link>
            </li>
            <NavDropdown title={<span style={{ color: 'white' }}>Mais</span>} className="fs-6" id="basic-nav-dropdown">
              <li>
                <Link className="dropdown-item" href={"/contact"}>contato</Link>
              </li>
              <li>
                <Link className="dropdown-item" href={"/client/perfil"} id="perfilLink">perfil</Link>
              </li>
            </NavDropdown>
          </Nav>
          <Form className="d-flex" role="search">
            <FormControl type="search" placeholder="Search" className="me-2" aria-label="Search" />
            <Button variant="primary" type="submit">Search</Button>
          </Form>
        </Navbar.Collapse>
      </div>
    </Navbar>
  );
}

export default CustomNavbar;