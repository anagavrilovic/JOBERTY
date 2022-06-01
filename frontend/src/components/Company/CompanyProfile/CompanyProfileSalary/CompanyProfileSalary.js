import React, { useEffect, useState } from 'react';
import Salary from '../../../Salaries/Salary/Salary';
import { getSalariesByCompany } from '../../../../api/CompanyApi';

function CompanyProfileSalary({companyId}) {
    const [salaries, setSalaries] = useState([])

    useEffect(() => {
        async function getSalaries(){
            const results = await getSalariesByCompany(companyId);
            setSalaries(results);
        }

        getSalaries();

    }, [companyId])

    return (
        <div>
            {
                salaries.map((s) => {
                    return <Salary key={s.id} salary={s}/> 
                })
            }
        </div>
    )
}

export default CompanyProfileSalary