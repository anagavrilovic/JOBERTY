import React, { useEffect, useState } from 'react';
import Company from '../Company/Company';
import classes from './AllCompanies.module.css';
import { getAllCompanies } from '../../../api/CompanyApi';

function AllCompanies() {
    const [companies, setCompanies] = useState([])

    useEffect(() => {
        async function getAll() {
            const results = await getAllCompanies();
            setCompanies(results);
        }

        getAll();
    }, [])

    return (
        <div className={classes.component} > {
            companies.map((company) => {
                return <Company key={company.name} company={company} />
            })
        }
        </div>
    )
}

export default AllCompanies