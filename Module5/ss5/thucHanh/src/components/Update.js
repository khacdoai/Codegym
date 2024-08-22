import {useParams} from "react-router-dom";

export function Update(){
    const param = useParams();
    return (
        <h1>Update {param.id}</h1>
    )
}
