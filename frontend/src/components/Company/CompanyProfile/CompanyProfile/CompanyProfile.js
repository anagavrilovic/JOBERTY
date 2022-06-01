import React from 'react';
import classes from './CompanyProfile.module.css';
import { useLocation } from 'react-router-dom';
import Synechron from '../../../../images/synechron.png';
import StarRate from '../../../StarRate/StarRate';
import { useState } from 'react';
import CompanyProfileNavigation from '../CompanyProfileNavigation/CompanyProfileNavigation';
import CompanyProfileAbout from '../CompanyProfileAbout/CompanyProfileAbout';
import CompanyProfileComments from '../CompanyProfileComments/CompanyProfileComments';
import CompanyProfileSalary from '../CompanyProfileSalary/CompanyProfileSalary';
import CompanyProfileInterview from '../CompanyProfileInterview/CompanyProfileInterview';
import CompanyProfileJobs from '../CompanyProfileJobs/CompanyProfileJobs';


function CompanyProfile() {

    const location = useLocation();

    const [activeTab, setactiveTab] = useState('about');

    const company = location.state.company;

    return (
        <div>
            <div className={classes.cover}></div>
            <div className={classes.page}>
                <div className={classes.mainInfoWrapper}>
                    <div className={classes.mainInfo}>
                        <img src={Synechron} alt={"Company logo"} className={classes.profilePhoto} />
                        <div className={classes.profileInfo}>
                            <h2 className={classes.companyName}>{company.name}</h2>
                            <div className={classes.stars}>
                                <StarRate rate={4} />
                                <p className={classes.rate}>{company.rate}</p>
                            </div>
                            <p className={classes.avgRate}>(average rate)</p>
                        </div>
                    </div>

                    {activeTab === 'comments' ? <button className={classes.button}>Leave a comment</button> : null}
                    {activeTab === 'salary' ? <button className={classes.button}>Leave a salary information</button> : null}
                    {activeTab === 'interview' ? <button className={classes.button}>Leave an interview impression</button> : null}
                </div>

                <CompanyProfileNavigation activeTab={activeTab} setactiveTab={(tab) => setactiveTab(tab)} />

                {activeTab === 'about' ? <CompanyProfileAbout company={company} /> : null}
                {activeTab === 'comments' ? <CompanyProfileComments companyId={company.id} /> : null}
                {activeTab === 'salary' ? <CompanyProfileSalary companyId={company.id} /> : null}
                {activeTab === 'interview' ? <CompanyProfileInterview companyId={company.id} /> : null}
                {activeTab === 'jobs' ? <CompanyProfileJobs companyId={company.id} /> : null}
            </div>
        </div>
    )
}

export default CompanyProfile