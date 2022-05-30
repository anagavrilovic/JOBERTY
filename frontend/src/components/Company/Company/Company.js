import React from 'react';
import classes from './Company.module.css';
import Synechron from '../../../images/synechron.png';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';

function Company() {

    const company = {
        name: "Synechron",
        rate: 4.1,
        impressionNumber: 83,
        cities: ['Novi Sad', 'Beograd'],
        employeeNumber: '251-500',
        industry: 'IT Services',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
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
                        <FontAwesomeIcon icon={faStar} className={company.rate > 0 ? classes.starYes : classes.starNo}/>
                        <FontAwesomeIcon icon={faStar} className={company.rate > 1.5 ? classes.starYes : classes.starNo}/>
                        <FontAwesomeIcon icon={faStar} className={company.rate > 2.5 ? classes.starYes : classes.starNo}/>
                        <FontAwesomeIcon icon={faStar} className={company.rate > 3.5 ? classes.starYes : classes.starNo}/>
                        <FontAwesomeIcon icon={faStar} className={company.rate > 4.5 ? classes.starYes : classes.starNo}/>
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
                <button className={classes.button}>View Company</button>
            </div>
        </div>
    )
}

export default Company