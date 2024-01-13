import React, { Component } from 'react';
import axios from 'axios';
import "./Listar.css";

const api = axios.create({
  baseURL: `http://localhost:8080/produtos`
});

class Listar extends Component {
  state = {
    produtos: []
  };

  componentDidMount() {
    api.get().then(res => {
      console.log(res.data);
      this.setState({ produtos: res.data });
    });
  }

  render() {
    return (
      <div className='main'>
        <h2>Produtos cadastrados </h2>
        {this.state.produtos.map(produto => (
          <h4 key={produto.id}>
            Nome: {produto.nome} - Descrição: {produto.descricao} - Preço: R${produto.preco}
          </h4>
        ))}
      </div>
    );
  }
}

export default Listar;
