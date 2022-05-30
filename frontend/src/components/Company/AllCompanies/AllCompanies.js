import React from 'react';
import Company from '../Company/Company';
import classes from './AllCompanies.module.css';

function AllCompanies() {
    const companies = [1, 2, 3, 4, 5, 6, 7];

    return (
        <div className={classes.component}>
            { companies.map((company) => {
                return <Company key={company}/>
            })}
        </div>
    )
}

export default AllCompanies