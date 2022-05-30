import React from 'react';
import classes from './Salary.module.css';

function Salary() {
    const salary = {
        workPosition: 'DevOps Engineer',
        seniority: 'Medior',
        employmentForm: 'Full time',
        minSallary: 508,
        maxSallary: 2200,
        numOfSalaries: 22
    }

    return (
        <div className={classes.component}>
            <div className={classes.content}>
                <div className={classes.info}>
                    <div className={classes.infoPart}>
                        <p className={classes.label}>Work position</p>
                        <p className={classes.value}>{salary.workPosition} ({salary.seniority})</p>
                    </div>
                    <div className={classes.infoPart}>
                        <p className={classes.label}>Form of Employment</p>
                        <p className={classes.value}>{salary.employmentForm}</p>
                    </div>
                    <div className={classes.infoPart}>
                        <p className={classes.label}>Neto Sallary</p>
                        <p className={`${classes.value} ${classes.salaryValue}`}>{(salary.minSallary + salary.maxSallary) / 2} EUR</p>
                    </div>
                    <div className={classes.infoPart}>
                        <p className={classes.label}></p>
                        <p className={classes.value}>({salary.numOfSalaries} salaries)</p>
                    </div>
                </div>
                <div className={classes.salaries}>
                    <div className={classes.salariesLabel}>
                        <p className={classes.label}>Min</p>
                        <div className={classes.avgSalary}>
                            <p>{(salary.minSallary + salary.maxSallary) / 2}</p>
                            <div className={classes.circle}></div>
                        </div>
                        <p className={classes.label}>Max</p>
                    </div>
                    <div className={classes.salariesValue}>
                        <p>{salary.minSallary}</p>
                        <div className={classes.scale}></div>
                        <p>{salary.maxSallary}</p>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Salary;