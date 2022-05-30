import React from 'react';
import classes from './CompanyProfileAbout.module.css';

function CompanyProfileAbout(props) {
    return (
        <div className={classes.component}>
            <div className={classes.info}>
                <div className={classes.infoColumn}>
                    <div className={classes.label}>
                        <p className={classes.textBold}>Name:</p>
                        <p className={classes.textBold}>Website:</p>
                    </div>
                    <div className={classes.value}>
                        <p>{props.company.name}</p>
                        <p>{props.company.website}</p>
                    </div>
                </div>

                <div className={classes.infoColumn}>
                    <div className={classes.label}>
                        <p className={classes.textBold}>Employees:</p>
                        <p className={classes.textBold}>Industry:</p>
                    </div>
                    <div className={classes.value}>
                        <p>{props.company.employeeNumber}</p>
                        <p>{props.company.industry}</p>
                    </div>
                </div>

                <div className={classes.infoColumn}>
                    <div className={classes.label}>
                        <p className={classes.textBold}>Origin:</p>
                        <p className={classes.textBold}>Offices in:</p>
                    </div>
                    <div className={classes.value}>
                        <p>{props.company.origin}</p>
                        <p>{props.company.cities.map((city) => { return <span key={city}>{city + ", "}</span> })}</p>
                    </div>
                </div>
            </div>

            <div className={classes.descriptionWrapper}>
                <div className={classes.descriptionQuestion}>Who we are?</div>
                <div className={classes.descriptionUnderline}></div>
                <div className={classes.description}>{props.company.description}</div>
            </div>
        </div>
    )
}

export default CompanyProfileAbout