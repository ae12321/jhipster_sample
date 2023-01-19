import './home.scss';

import React from 'react';
import { Link, useNavigate } from 'react-router-dom';

import { Row, Col, Alert, Button } from 'reactstrap';

import { useAppDispatch, useAppSelector } from 'app/config/store';
import { login } from 'app/shared/reducers/authentication';

export const Privacy = () => {
  const account = useAppSelector(state => state.authentication.account);
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const handleAgree = () => {
    // dispatch(login('user', 'user'));
    navigate('/register');
  };
  const handleDisagree = () => {
    navigate('/');
  };

  return (
    <Row>
      <h1>this is privacy.</h1>

      <textarea name="" id="" cols={30} rows={10}>
        aa bb cc
      </textarea>
      <Col xs={6}>
        <Button style={{ width: '100%' }} color="info" onClick={handleAgree}>
          Agree
        </Button>
      </Col>
      <Col xs={6}>
        <Button style={{ width: '100%' }} color="danger" onClick={handleDisagree}>
          Disagree
        </Button>
      </Col>
    </Row>
  );
};

export default Privacy;
