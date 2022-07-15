import * as yup from "yup";

const nameRegex = /^[a-zA-ZšŠđĐžŽčČćĆ 0-9.]+$/;
const websiteRegex = /((?:(?:http?|ftp)[s]*:\/\/)?[a-z0-9-%/&=?.]+\.[a-z]{2,4}\/?([^\s<>#%",{}\\|\\^[\]`]+)?)/;
const mediumPasswordRegex = /^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})/;
const strongPasswordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{10,})/;

const schema = yup.object().shape({
    companyName:
        yup.string()
            .required("Company name is required.")
            .matches(nameRegex, "Company name should be letters, digits or dots only."),
    cities:
        yup.string()
            .required("Cities are required.")
            .max(256, "Maximum number of characters is 256."),
    email:
        yup.string()
            .email("Invalid e-mail address.")
            .required("Email is required."),
    website:
        yup.string()
            .required("Website is required.")
            .matches(websiteRegex, "Invalid website format."),
    companySize:
        yup.string()
            .required("Company size is required.")
            .matches(nameRegex, "Company size should be letters and digits only."),
    industry:
        yup.string()
            .max(256, "Maximum number of characters is 256.")
            .required("Industry is required."),
    password:
        yup.string()
            .required("Password is required.")
            .matches(mediumPasswordRegex, "Password is too weak.")
            .matches(strongPasswordRegex, "Password has medium strength."),
    confirmPassword:
        yup.string()
            .oneOf([yup.ref("password")], "Passwords do not match.")
            .required("Please confirm your password."),
});

export default schema;