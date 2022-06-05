import React from 'react';
import classes from './Job.module.css';
import Synechron from '../../../images/synechron.png';


function Job({ job, publishToDislinkt }) {

    return (
        <div className={classes.component}>
            <div className={classes.imageWrapper}>
                <img src={Synechron} alt={job.company.name} className={classes.image} />
            </div>
            <div className={classes.jobInfo}>
                <h3 className={classes.jobTitle}>{job.position}</h3>
                <p className={classes.mainText}>{job.company.name}</p>
                <p className={classes.mainText}>
                    {job.company.cities}
                </p>
                <p className={classes.mainText}>{job.seniority.charAt(0).toUpperCase() + job.seniority.slice(1)}</p>

                <div className={classes.technologies}>
                    {job.prerequisites.split(',').map((technology) => {
                        return <div className={classes.technology} key={technology}>{technology}</div>
                    })}
                </div>

                <p className={classes.expiresIn}>{Math.ceil((job.expires - new Date().getTime()) / (1000 * 3600 * 24))} days left</p>
            </div>
            {
                publishToDislinkt ?
                    <button className={classes.button}
                        onClick={publishToDislinkt ? () => publishToDislinkt() : null}>
                        Publish
                    </button>
                    : null
            }
        </div>
    )
}

export default Job;