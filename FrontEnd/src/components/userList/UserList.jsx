import { useState, useEffect } from 'react';
import axios from "axios";
import './UserList.css'
import { Link } from 'react-router-dom';

function UserList() {
    const [users, setUser] = useState([]);

    useEffect(() => {
      axios.get('http://localhost:8080/users')
      .then(response => {
        setUser(response.data);
      }).catch(error => {
        console.error('erro ao buscar usuários', error);
      })
    }, []);

    return(
        <div id='UserList'>
            <h2>Usuários Cadastrados</h2>
            <table>
              <thead>
                <th>Id</th>
                <th>Nome</th>
                <th>Email</th>
              </thead>
              
              {users.map(user => (
                <tr key={user.id}>
                  <th>{user.id}</th>
                  <th>{user.name}</th>
                  <th>{user.email}</th>
                </tr>
              ))}
            </table>
            <Link to="/">Cadastrar novo usuário</Link>
        </div>
    );
}

export default UserList;