import { Link } from "react-router-dom";
import classes from "./Navbar.module.css";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBars } from "@fortawesome/free-solid-svg-icons";
import { faRightFromBracket } from "@fortawesome/free-solid-svg-icons";
import {faMagnifyingGlass} from '@fortawesome/free-solid-svg-icons'

import { useState } from "react";
import { useDispatch } from "react-redux";
import { logout } from "../../features/user";
import j from "../../images/j.png"

function Navbar() {
    var [mobileNavClicked, setMobileNavClicked] = useState(false);

    const dispatch = useDispatch();

    function handleLogOut() {
        dispatch(logout());
    }

    return (
        <div>
            {mobileNavClicked ? (<div className={classes.backdrop} onClick={() => setMobileNavClicked(false)} ></div>) : null}

            <nav className={classes.nav}>
                <div className={classes.navLogo}>
                    <Link to="/home" className={classes.logoLink}>
                        <img src={j} alt="Joberty" className={classes.logo} />
                        <p className={classes.logoText}>oberty</p>
                    </Link>
                    <div className={classes.formItem}>
                        <FontAwesomeIcon icon={faMagnifyingGlass} className={classes.icon} />
                        <input type='text' placeholder='Search companies...' />
                    </div>
                </div>
                <div>
                    <Link to="/companies" className={classes.link}>
                        Companies
                    </Link>
                    <Link to="/jobs" className={classes.link}>
                        Jobs
                    </Link>
                    <Link to="/salaries" className={classes.link}>
                        Salaries
                    </Link>
                    <Link to="/employers" className={classes.link}>
                        For Employers
                    </Link>
                    <Link to="/" className={classes.link}>
                        <FontAwesomeIcon icon={faRightFromBracket} onClick={handleLogOut} />
                    </Link>
                    <FontAwesomeIcon icon={faBars} className={classes.menuIcon} onClick={() => setMobileNavClicked(true)} />
                </div>
            </nav>

            {mobileNavClicked ? (
                <nav className={classes.mobileNav}>
                    <div className={classes.mobileNavLinks}>
                        <Link to="/home" className={classes.mobileLink} onClick={() => setMobileNavClicked(false)} >
                            Home
                        </Link>
                        <Link to="/companies" className={classes.mobileLink} onClick={() => setMobileNavClicked(false)} >
                            Companies
                        </Link>
                        <Link to="/jobs" className={classes.mobileLink} onClick={() => setMobileNavClicked(false)}  >
                            Jobs
                        </Link>
                        <Link to="/salaries" className={classes.mobileLink} onClick={() => setMobileNavClicked(false)}  >
                            Salaries
                        </Link>
                        <Link to="/employers" className={classes.mobileLink} onClick={() => setMobileNavClicked(false)}  >
                            For Employers
                        </Link>
                        <Link to="/" className={classes.mobileLink}>
                            LogOut <FontAwesomeIcon icon={faRightFromBracket} />
                        </Link>
                    </div>
                </nav>
            ) : null}
        </div>
    );
}

export default Navbar;
