import { useLocation } from 'react-router-dom';
import { Route, Routes } from 'react-router-dom';

import Homepage from './pages/Homepage/Homepage';
import Mainpage from './pages/Mainpage/Mainpage';
import Navbar from './components/Navbar/Navbar';
import Companies from './pages/Companies/Companies';
import Jobs from './pages/Jobs/Jobs';
import Salaries from './pages/Salaries/Salaries';
import Employers from './pages/Employers/Employers';

import './App.css';

function App() {
    const location = useLocation();

    return (
        <div className="App">
            { location.pathname !== '/' ? <Navbar /> : null }
            <Routes>
                <Route path='/' element={ <Mainpage /> } />
                <Route path='/home' element={ <Homepage /> } />
                <Route path='/companies' element={ <Companies /> } />
                <Route path='/jobs' element={ <Jobs /> } />
                <Route path='/salaries' element={ <Salaries /> } />
                <Route path='/employers' element={ <Employers /> } />
            </Routes>
        </div>
    );
}

export default App;
