import classes from "./Salaries.module.css";
import Caption from "../../components/Caption/Caption";

function Salaries() {
    return (
        <div className={classes.page}>
            <Caption caption="View Salary Information"/>
        </div>
    );
}

export default Salaries;