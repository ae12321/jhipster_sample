import './home.scss';

import React from 'react';
import { Link } from 'react-router-dom';

import { Row, Col, Alert } from 'reactstrap';

import { useAppSelector } from 'app/config/store';

export const Home = () => {
  // const account = useAppSelector(state => state.authentication.account);

  return (
    <Row>
      <h1>this is login.</h1>
      <Link to="/privacy" className="alert-link">
        go to privacy
      </Link>
    </Row>
  );
};

export default Home;
