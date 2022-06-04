import React from 'react';
import classes from './Job.module.css';
import Synechron from '../../../images/synechron.png';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar, faCircle } from '@fortawesome/free-solid-svg-icons';

function Job(props) {
    const jobAd = {
        companyName: "Synechron",
        job: "Software Developer / Back-end",
        companyRate: 4.1,
        cities: ['Beograd', 'Novi Sad'],
        seniority: 'Junior',
        expiresIn: new Date('06/12/2022'),
        technologies: ['Java', 'AWS', 'Spring Boot', 'No SQL', 'REST']
    }

    return (
        <div className={classes.component}>
            <div className={classes.imageWrapper}>
                <img src={Synechron} alt={jobAd.companyName} className={classes.image} />
            </div>
            <div className={classes.jobInfo}>
                <h3 className={classes.jobTitle}>{jobAd.job}</h3>
                <p className={classes.mainText}>{jobAd.companyName}</p>
                <p className={classes.mainText}>
                    (<FontAwesomeIcon icon={faStar} className={classes.starIcon} /> {jobAd.companyRate})
                    <FontAwesomeIcon icon={faCircle} className={classes.dotIcon} />
                    {jobAd.cities.map((city) => { return city + ", " })}
                </p>
                <p className={classes.mainText}>{jobAd.seniority}</p>

                <div className={classes.technologies}>
                    {jobAd.technologies.map((technology) => {
                        return <div className={classes.technology} key={technology}>{technology}</div>
                    })}
                </div>

                <p className={classes.expiresIn}>{Math.ceil((jobAd.expiresIn.getTime() - new Date().getTime()) / (1000 * 3600 * 24))} days left</p>
            </div>
            {
                props.publishToDislinkt ?
                    <button className={classes.button}
                        onClick={props.publishToDislinkt ? () => props.publishToDislinkt() : null}>
                        Publish
                    </button>
                    : null
            }
        </div>
    )
}

export default Job;