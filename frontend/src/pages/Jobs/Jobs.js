import classes from "./Jobs.module.css";
import Caption from "../../components/Caption/Caption";
import CompanySearch from "../../components/Company/CompanySearch/CompanySearch";
import JobFilter from "../../components/Jobs/JobFilter/JobFilter";

function Jobs() {
    return (
        <div className={classes.page}>
            <div className={classes.header}>
                <Caption caption="View Job Ads" />
                <CompanySearch placeholder="Work position, company or key word" />
                <JobFilter />
            </div>
        </div>
    );
}

export default Jobs;