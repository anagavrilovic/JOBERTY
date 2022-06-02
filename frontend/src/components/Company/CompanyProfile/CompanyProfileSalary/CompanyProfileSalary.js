import React from 'react';
import Salary from '../../../Salaries/Salary/Salary';

function CompanyProfileSalary({companyId, salaries}) {

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