import axios from "axios";

const BASE_URL = "http://localhost:8080";

const axiosInstance = axios.create({
    baseURL: BASE_URL,
});

const apiService = {
    createMovie: async (movieData) => {
        try {
            const response = await axiosInstance.post("/movie", movieData);
            return response.data;
        } catch (error) {
            throw error;
        }
    },
    updateMovie: async (id, update) => {
        try {
            const response = await axiosInstance.put(
                `/movie/${id}`,
                update
            );
            return response.data;
        } catch (error) {
            throw error;
        }
    },
    getProductById: async (id) => {
        try {
            const response = await axiosInstance.get(`/product/${id}`);
            return response.data;
        } catch (error) {
            throw error;
        }
    },

}
export default apiService;