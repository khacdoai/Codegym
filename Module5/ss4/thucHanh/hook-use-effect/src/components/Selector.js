import {useState, useEffect} from "react";

function Selector() {
    let [selected, setSelected] = useState("0");
    let [valueSelected, setValueSelected] = useState("");

    const choice = e => {
        setSelected(e.target.value);
    }
    useEffect(() => {
        switch (selected) {
            case "0":
                choice(1);
            case "1":
                choice(2);
            case "2":
                choice(3);
            case "3":
                choice(4);
            case "4":
                choice(5);


        }
        }
    );

}