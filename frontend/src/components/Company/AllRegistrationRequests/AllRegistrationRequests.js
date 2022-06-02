import React, { useEffect, useState } from 'react';
import classes from './AllRegistrationRequests.module.css'
import RegistrationRequest from '../RegistrationRequest/RegistrationRequest';
import { getAllRegistrationRequests } from '../../../api/CompanyRegistrationApi'

function AllRegistrationRequests() {
    const [requests, setRequests] = useState([])

    useEffect(() => {
        async function getAll() {
            const results = await getAllRegistrationRequests();
            setRequests(results);
        }

        getAll();
    }, [])

    return (
        <div className={classes.component} > {
            requests.map((company) => {
                return <RegistrationRequest key={company.name} company={company} />
            })
        }
        </div>
    )
}

export default AllRegistrationRequests