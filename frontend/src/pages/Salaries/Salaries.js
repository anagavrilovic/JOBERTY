import classes from "./Salaries.module.css";
import Caption from "../../components/Caption/Caption";
import SalariesFilter from "../../components/Salaries/SalariesFilter/SalariesFilter";
import Salary from "../../components/Salaries/Salary/Salary";

function Salaries() {
    return (
        <div className={classes.page}>
            <div className={classes.header}>
                <Caption caption="View Salary Information" />
                <SalariesFilter />
            </div>
            <div className={classes.content}>
                <Salary/>
                <p>* The values shown are based on the entered "Salary and benefits" of the Joberty user.</p>
                <p className={classes.boldText}>You can also research salaries on individual company profiles in the section: "Salaries and benefits".</p>
            </div>
        </div>
    );
}

export default Salaries;