import React from 'react';
import './App.css';
import { useState } from 'react';
import axios from "axios";
import Listar from "./component/Listar/Listar"
import CampoTexto from './component/CampoTexto';
import Botao from './component/Botao';

function App() {

  const [id, setId] = useState('');
  const [nome, setNome] = useState('')
  const [descricao, setDescricao] = useState('')
  const [preco, setPreco] = useState('')

  const aoSalvar = (event) => {
    event.preventDefault()
    const data = {
      nome: nome,
      descricao: descricao,
      preco: preco,
    };

    axios.post('http://localhost:8080/produtos', data)
      .then(response => {
        console.log(response.data);
        alert("Produto cadastrado!")
        setNome('')
        setDescricao('')
        setPreco('')
      })
      .catch(error => {
        console.log(error);
        console.log(data);
      });
  };

  const aoAtualizar = (event) => {
    event.preventDefault()
    const data = {
      nome: nome,
      descricao: descricao,
      preco: preco,
    };

    axios.put(`http://localhost:8080/produtos/${id}`, data)
      .then(response => {
        console.log(response.data);
        alert("Produto atualizado!")
        setNome('')
        setDescricao('')
        setPreco('')
      })
      .catch(error => {
        console.log(error);
        console.log(data);
      });
  };

  const aoExcluir = (event) => {
    event.preventDefault()

    axios.delete(`http://localhost:8080/produtos/${id}`)
      .then(response => {
        console.log(response.data);
        alert("Produto excluído!");
        setNome('');
        setDescricao('');
        setPreco('');
      })
      .catch(error => {
        console.log(error);
      });
  };






  return (
    <div>
      <section>
        <form onSubmit={aoSalvar} class='cadastro'>
          <h1>Cadastro de produto</h1>
          <CampoTexto value={nome} obrigatorio={true} onChange={event => setNome(event.target.value)} placeholder="Nome" />
          <CampoTexto value={descricao} obrigatorio={true} onChange={event => setDescricao(event.target.value)} placeholder="Descrição" />
          <CampoTexto value={preco} obrigatorio={true} onChange={event => setPreco(event.target.value)} placeholder="Preço" />
          <Botao>
            Cadastrar
          </Botao>
        </form>
      </section>
      <section>
        <form onSubmit={aoAtualizar} class='atualizar'>
          <h1>Atualizar de produto</h1>
          <CampoTexto value={id} obrigatorio={true} onChange={event => setId(event.target.value)} placeholder="Digite o Id" />
          <CampoTexto value={nome} obrigatorio={false} onChange={event => setNome(event.target.value)} placeholder="Nome" />
          <CampoTexto value={descricao} obrigatorio={false} onChange={event => setDescricao(event.target.value)} placeholder="Descrição" />
          <CampoTexto value={preco} obrigatorio={false} onChange={event => setPreco(event.target.value)} placeholder="Preço" />
          <Botao>
            Atualizar
          </Botao>
        </form>
      </section>
      <section>
        <form onSubmit={aoExcluir} class='deletar'>
          <h1>Deletar produto</h1>
          <CampoTexto value={id} obrigatorio={true} onChange={event => setId(event.target.value)} placeholder="Digite o Id" />
          <Botao>
            Excluir
          </Botao>
        </form>
      </section>
      <Listar />
    </div>

  )
}

export default App;
