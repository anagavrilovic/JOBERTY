import React from 'react';
import classes from './CompanyProfile.module.css';
import { useParams } from 'react-router-dom';
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
    let { id } = useParams();
    let { name } = useParams();

    const [activeTab, setactiveTab] = useState('about');

    const company = {
        id: id,
        name: name,
        rate: 4.1,
        impressionNumber: 83,
        cities: ['Novi Sad', 'Beograd'],
        employeeNumber: '251-500',
        industry: 'IT Services',
        website: 'www.synechron.com',
        origin: 'SAD',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
    }

    return (
        <div>
            <div className={classes.cover}></div>
            <div className={classes.page}>
                <div className={classes.mainInfoWrapper}>
                    <div className={classes.mainInfo}>
                        <img src={Synechron} alt={name} className={classes.profilePhoto} />
                        <div className={classes.profileInfo}>
                            <h2 className={classes.companyName}>{company.name}</h2>
                            <div className={classes.stars}>
                                <StarRate rate={company.rate} />
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
                {activeTab === 'salary' ? <CompanyProfileSalary ompanyId={company.id} /> : null}
                {activeTab === 'interview' ? <CompanyProfileInterview companyId={company.id} /> : null}
                {activeTab === 'jobs' ? <CompanyProfileJobs companyId={company.id} /> : null}
            </div>
        </div>
    )
}

export default CompanyProfile