import React from 'react';
import Salary from '../../../Salaries/Salary/Salary';

function CompanyProfileSalary() {
    const salaries = [1, 2, 3, 4];

    return (
        <div>
            {
                salaries.map((s) => {
                    return <Salary key={s}/> 
                })
            }
        </div>
    )
}

export default CompanyProfileSalary