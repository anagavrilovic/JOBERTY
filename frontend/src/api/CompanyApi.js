import { axiosInstance } from "./AxiosInstance";

export async function getAllCompanies() {
    const response = await axiosInstance.get('company/all');
    return response.data;
}

export async function getCommentsByCompany(companyId) {
    const response = await axiosInstance.get(`comment/all/${companyId}`);
    return response.data;
}

export async function getSalariesByCompany(companyId) {
    const response = await axiosInstance.get(`salary/all/${companyId}`);
    return response.data;
}

export async function getInterviewsByCompany(companyId) {
    const response = await axiosInstance.get(`interview/all/${companyId}`);
    return response.data;
}