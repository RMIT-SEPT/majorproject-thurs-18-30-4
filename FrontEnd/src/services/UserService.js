import axios from "axios";
import headerService from "./HeaderService";

const URL_API_ROLE = "http://localhost:8080/api/test/";

class UserService {
  //public permission
  getPublicContent() {
    return axios.get(URL_API_ROLE + "all");
  }
  //customer permission
  getCustomerBoard() {
    return axios.get(URL_API_ROLE + "customer", { headers: headerService() });
  }
  //worker permission
  getWorkerBoard() {
    return axios.get(URL_API_ROLE + "worker", { headers: headerService() });
  }
  //admin permission
  getAdminBoard() {
    return axios.get(URL_API_ROLE + "admin", { headers: headerService() });
  }
}

export default new UserService();
