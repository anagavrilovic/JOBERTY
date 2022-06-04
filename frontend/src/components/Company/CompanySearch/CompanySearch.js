import React from 'react';
import classes from './CompanySearch.module.css';
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useNavigate } from 'react-router-dom';
function CompanySearch(props) {

    const navigate = useNavigate()
    function newJobOffer(){
        navigate(`/job-offer`)
    }

    return (
        <div className={classes.component}>
            <div className={classes.search}>
                <FontAwesomeIcon icon={faMagnifyingGlass} className={classes.icon} />
                <input type='text' placeholder={props.placeholder} />
                <button className={classes.button}>Search</button>
                <button className={classes.buttonJob} onClick={newJobOffer}>Create job offer</button>
            </div>
        </div>
    )
}

export default CompanySearch;