import React, { useEffect, useState } from 'react'
import axios from "axios"


export default function Home() {

    const GET_REQUEST = 'http://localhost:8080/users';

    const [users, setUsers] = useState([]);

    useEffect(() => {
        loadUsers();
    }, []);

    const loadUsers = async () => {
        const result = await axios.get(GET_REQUEST);
        setUsers(result.data);
    };

    return (
        <div className="container">
            <div className='py-4'>

                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Username</th>
                            <th scope="col">Email</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                        {
                            users.map((user, index) => (
                                <tr>
                                    <th scope="row" key={index}>{index+1}</th>
                                    <td>{user.name}</td>
                                    <td>{user.username}</td>
                                    <td>{user.email}</td>
                                </tr>
                            ))
                        }

                    </tbody>
                </table>
            </div>

        </div>
    )
}
