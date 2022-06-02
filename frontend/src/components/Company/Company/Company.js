import React from 'react';
import classes from './Company.module.css';
import Synechron from '../../../images/synechron.png';
import { useNavigate } from 'react-router-dom';
import StarRate from '../../StarRate/StarRate';

function Company({company}) {
    const navigate = useNavigate();

    function handleViewCompany() {
        navigate(`/company/${company.id}/${company.name}`, {state: {company: company }});
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
                        <StarRate rate={4} />
                    </div>
                    <p className={classes.textBold}>{company.rate}</p>
                </div>
                <p className={classes.textBold}>10 impressions</p>
            </div>
            <div className={classes.about}>
                <div className={classes.shortAbout}>
                    <div className={classes.shortAboutLabels}>
                        <p>Website:</p>
                        <p>Employees:</p>
                        <p>Industry:</p>
                    </div>
                    <div className={classes.shortAboutValues}>
                        <p className={classes.textBold}>{company.website}</p>
                        <p className={classes.textBold}>{company.size}</p>
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