import React, { useEffect, useState } from "react";
import { Typography, TextField, Button, Paper, Box } from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";

const initial = {
  id: "",
  name: "",
  areaLocated: 0,
  noOfFlatsAvailable: 0,
  noOfFlatsSold: 0,
  ratePerFlat: 0,
};

const Edit = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [apartment, setApartment] = useState(initial);
  const [currId] = useState(location.state.id);


  useEffect(() => {
    const fetchInitialPosts = async (id) => {  
      const response = await axios.get(`http://localhost:8080/apartment/${id}`);
      console.log(response.data);
      setApartment(response.data);
    };
    console.log("currId : %d ",currId);
    fetchInitialPosts(currId);
  }, [currId]);

  const handleSubmit = (e) => {
    e.preventDefault();

    console.log("inside put calling....");
    console.log(apartment);
    
    axios     
      .put("http://localhost:8080/apartment",apartment)
      .then((resp) => {
        console.log(resp.data);
        navigate("/");  // Navigate only after success
      })
      .catch((error) => {
        console.log(error);
      });
  };


  return (
    <Paper sx={{ padding: "1%" }} elevation={0}>
      <Typography sx={{ margin: "3% auto" }} align="center" variant="h5">
        Edit New Post
      </Typography>
      <form autoComplete="off" noValidate onSubmit={handleSubmit}>
        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            flexDirection: "column",
          }}
        >
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            onChange={(e) => setApartment({ ...apartment, id: e.target.value })}
            label="Enter your Apartment ID"
            variant="outlined"
            value={apartment.id}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setApartment({ ...apartment, name: e.target.value })}
            label="Apartment name"
            variant="outlined"
            value={apartment.name}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setApartment({ ...apartment, areaLocated: e.target.value })}
            label="Apartment Located At"
            variant="outlined"
            value={apartment.areaLocated}
          />
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) =>
              setApartment({ ...apartment, noOfFlatsAvailable: e.target.value })
            }
            label="No of flats available"
            variant="outlined"
            value={apartment.noOfFlatsAvailable}
          />
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) =>
              setApartment({ ...apartment, noOfFlatsSold: e.target.value })
            }
            label="No of Flats Sold"
            variant="outlined"
            value={apartment.noOfFlatsSold}
          />
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) =>
              setApartment({ ...apartment, ratePerFlat: e.target.value })
            }
            label="Rate Per Flat"
            variant="outlined"
            value={apartment.ratePerFlat}
          />
          
          <Button
            sx={{ width: "50%", margin: "2% auto" }}
            variant="contained"
            type="submit"
          >
            Submit
          </Button>
        </Box>
      </form>
    </Paper>
  );
};

export default Edit;
