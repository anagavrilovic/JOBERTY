import React from 'react';
import classes from './Company.module.css';
import Synechron from '../../../images/synechron.png';
import { useNavigate } from 'react-router-dom';
import StarRate from '../../StarRate/StarRate';

function Company() {
    const navigate = useNavigate();

    const company = {
        id: 1,
        name: "Synechron",
        rate: 4.1,
        impressionNumber: 83,
        cities: ['Novi Sad', 'Beograd'],
        employeeNumber: '251-500',
        industry: 'IT Services',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
    }

    function handleViewCompany() {
        navigate(`/company/${company.id}/${company.name}`);
    }

    return (
        <div className={classes.component}>
            <div className={classes.companyName}>
                <img src={Synechron} alt={company.name} />
                <h3>{company.name}</h3>
            </div>
            <div className={classes.impressions}>
                <div className={classes.rate}>
                    <div className={classes.stars}>
                        <StarRate rate={company.rate} />
                    </div>
                    <p className={classes.textBold}>{company.rate}</p>
                </div>
                <p className={classes.textBold}>{company.impressionNumber} impressions</p>
            </div>
            <div className={classes.about}>
                <div className={classes.shortAbout}>
                    <div className={classes.shortAboutLabels}>
                        <p>Cities:</p>
                        <p>Employees:</p>
                        <p>Industry:</p>
                    </div>
                    <div className={classes.shortAboutValues}>
                        <p className={classes.textBold}>{company.cities.map((city) => { return city + ','})}</p>
                        <p className={classes.textBold}>{company.employeeNumber}</p>
                        <p className={classes.textBold}>{company.industry}</p>
                    </div>
                </div>
                <div className={classes.description}>{company.description}</div>
            </div>
            <div className={classes.buttonDetails}>
                <button className={classes.button} onClick={handleViewCompany}>View Company</button>
            </div>
        </div>
    )
}

export default Company