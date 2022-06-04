import axios from 'axios';

const JobOfferService = {

    save: function(data) {
        return axios.post(`http://localhost:8088/job-offer`,data, {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            },
        })

    },

    sendOffer: function(id) {
        return axios.post(`http://localhost:8088/job-offer/`+id+"/send-token", {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            },
        })

    }


}
export default JobOfferService;