import classes from './Homepage.module.css'
import {faMagnifyingGlass} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

function Homepage(props) {

    return (
        <div className={classes.page}>
            <div className={classes.search}>
                <h1 className={classes.caption}>Find out how it is to work in companies in the world</h1>
                <div className={classes.formItem}>
                    <FontAwesomeIcon icon={faMagnifyingGlass} className={classes.icon}/>
                    <input type='text' required placeholder='Search companies...' />
                </div>
            </div>
        </div>
    );
}

export default Homepage;