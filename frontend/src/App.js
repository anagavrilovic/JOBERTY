import { useLocation } from 'react-router-dom';
import { Route, Routes } from 'react-router-dom';

import Homepage from './pages/Homepage/Homepage';
import Mainpage from './pages/Mainpage/Mainpage';
import Navbar from './components/Navbar/Navbar';
import Companies from './pages/Companies/Companies';
import Jobs from './pages/Jobs/Jobs';
import Salaries from './pages/Salaries/Salaries';
import Employers from './pages/Employers/Employers';
import ProtectedRoute from './ProtectedRoute'
import CreateJobOffer from './components/Jobs/CreateJobOffer/CreateJobOffer';
import './App.css';
import CompanyProfile from './components/Company/CompanyProfile/CompanyProfile/CompanyProfile';

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
                <Route path='/employers' element={ <ProtectedRoute Component = {Employers} Roles="['ROLE_ADMIN]" /> } />
                <Route path='/job-offer' element={ <ProtectedRoute Component = {CreateJobOffer} Roles="['ROLE_COMPANY_OWNER]" /> } />
                <Route path='/company/:id/:name' element={ <CompanyProfile /> } />
            </Routes>
        </div>
    );
}

export default App;
