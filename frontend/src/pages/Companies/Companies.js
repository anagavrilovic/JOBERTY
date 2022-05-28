import classes from "./Companies.module.css";
import Caption from "../../components/Caption/Caption";
import CompanySearch from "../../components/Company/CompanySearch/CompanySearch";
import CompanyFilter from "../../components/Company/CompanyFilter/CompanyFilter";

function Companies() {
    return (
        <div className={classes.page}>
            <div className={classes.header}>
                <Caption caption="Overview of All Companies" />
                <CompanySearch placeholder="Company name, city or key word"/>
                <CompanyFilter />
            </div>

        </div>
    );
}

export default Companies;