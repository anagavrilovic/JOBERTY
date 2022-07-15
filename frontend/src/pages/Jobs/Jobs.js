import classes from "./Jobs.module.css";
import Caption from "../../components/Caption/Caption";
import CompanySearch from "../../components/Company/CompanySearch/CompanySearch";
import JobFilter from "../../components/Jobs/JobFilter/JobFilter";
import AllJobs from "../../components/Jobs/AllJobs/AllJobs";

import { useState, useEffect } from 'react';
import { axiosInstance } from "../../api/AxiosInstance"

function Jobs() {

    const [jobs, setJobs] = useState();

    useEffect(() => {
        axiosInstance.get(`/job-offer/all`)
            .then((response) => {
                setJobs(response.data);
            })
    }, []);

    return (
        <div className={classes.page}>
            <div className={classes.header}>
                <Caption caption="View Job Ads" />
                <CompanySearch placeholder="Work position, company or key word" />
                <JobFilter />
            </div>

            <div className={classes.content}>
                <div className={classes.contentHeader}>
                    <p>{jobs ? jobs.length : ''} Ads</p>

                    <div className={classes.sort}>
                        <p>Sort:</p>
                        <select name="Sort" defaultValue="" className={classes.select}>
                            <option value="lastest" >Latest first</option>
                            <option value="dateDesc" >Oldest first</option>
                        </select>
                    </div>
                </div>

                <AllJobs jobs={jobs ? jobs : []} />
            </div>
        </div>
    );
}

export default Jobs;