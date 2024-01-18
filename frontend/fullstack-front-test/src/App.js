import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import axios from "axios"

function App() {
  return <div className="App">

    <Navbar/>
    <Home/>



  </div>;
}

export default App;
