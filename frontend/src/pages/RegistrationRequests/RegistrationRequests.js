import classes from "./RegistrationRequests.module.css";
import Caption from "../../components/Caption/Caption";
import CompanySearch from "../../components/Company/CompanySearch/CompanySearch";
import CompanyFilter from "../../components/Company/CompanyFilter/CompanyFilter";
import AllRegistrationRequests from "../../components/Company/AllRegistrationRequests/AllRegistrationRequests";

function RegistrationRequests() {
    return (
        <div className={classes.page}>
            <Caption caption="Company registration requests"/>
            <CompanySearch placeholder="Company name, city or key word" />
            <CompanyFilter />

            <div className={classes.content}>
                <AllRegistrationRequests/>
            </div>
        </div>
    );
}

export default RegistrationRequests;